package cn.itcast.haoke.dubbo.api.interceptor;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 包装HttpServletRequest（
 * 在request中的输入流只能读取一次
 * ）
 *
 * @author Kang Yong
 * @date 2022/3/27
 * @since 1.0.0
 */
public class MyServletRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    public MyServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        body = IOUtils.toByteArray(super.getInputStream());
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new RequestBodyCachingInputStream(body);
    }

    /**
     * 内部类
     *
     * @author Kang Yong
     * @date 2022/3/27
     */
    private class RequestBodyCachingInputStream extends ServletInputStream {

        private byte[] body;
        private int lastIndexRetrieved = -1;
        private ReadListener listener;

        public RequestBodyCachingInputStream(byte[] body) {
            this.body = body;
        }

        @Override
        public boolean isReady() {
            return isFinished();
        }

        @Override
        public boolean isFinished() {
            return lastIndexRetrieved == body.length - 1;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            if (listener == null) {
                throw new IllegalArgumentException("listener cann not be null");
            }
            if (this.listener != null) {
                throw new IllegalArgumentException("listener has been set");
            }
            this.listener = listener;

            if (!isFinished()) {
                try {
                    listener.onAllDataRead();
                } catch (IOException e) {
                    listener.onError(e);
                }
            } else {
                try {
                    listener.onAllDataRead();
                } catch (IOException e) {
                    listener.onError(e);
                }
            }
        }

        /**
         * Reads the next byte of data from the input stream. The value byte is
         * returned as an <code>int</code> in the range <code>0</code> to
         * <code>255</code>. If no byte is available because the end of the stream
         * has been reached, the value <code>-1</code> is returned. This method
         * blocks until input data is available, the end of the stream is detected,
         * or an exception is thrown.
         *
         * <p> A subclass must provide an implementation of this method.
         *
         * @return the next byte of data, or <code>-1</code> if the end of the
         * stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        @Override
        public int read() throws IOException {
            if (isFinished()) {
                return -1;
            }

            int i = body[lastIndexRetrieved + 1];
            lastIndexRetrieved++;
            if (isFinished() && listener != null) {
                try {
                    listener.onAllDataRead();
                } catch (IOException e) {
                    listener.onError(e);
                    throw e;
                }
            }
            return i;
        }

        /**
         * Returns an estimate of the number of bytes that can be read (or
         * skipped over) from this input stream without blocking by the next
         * invocation of a method for this input stream. The next invocation
         * might be the same thread or another thread.  A single read or skip of this
         * many bytes will not block, but may read or skip fewer bytes.
         *
         * <p> Note that while some implementations of {@code InputStream} will return
         * the total number of bytes in the stream, many will not.  It is
         * never correct to use the return value of this method to allocate
         * a buffer intended to hold all data in this stream.
         *
         * <p> A subclass' implementation of this method may choose to throw an
         * {@link IOException} if this input stream has been closed by
         * invoking the {@link #close()} method.
         *
         * <p> The {@code available} method for class {@code InputStream} always
         * returns {@code 0}.
         *
         * <p> This method should be overridden by subclasses.
         *
         * @return an estimate of the number of bytes that can be read (or skipped
         * over) from this input stream without blocking or {@code 0} when
         * it reaches the end of the input stream.
         * @throws IOException if an I/O error occurs.
         */
        @Override
        public int available() throws IOException {
            return body.length - lastIndexRetrieved - 1;
        }

        /**
         * Closes this input stream and releases any system resources associated
         * with the stream.
         *
         * <p> The <code>close</code> method of <code>InputStream</code> does
         * nothing.
         *
         * @throws IOException if an I/O error occurs.
         */
        @Override
        public void close() throws IOException {
            lastIndexRetrieved = body.length - 1;
            body = null;
        }
    }
}
