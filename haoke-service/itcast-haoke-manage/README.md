# 好客租房

## 一、目录结构

* itcast-haoke-manage（后端服务父工程）
  * doc（文档相关）
  * itcast-haoke-manage-api-server（api服务）
  * itcast-haoke-manage-api-dubbo-server（dubbo服务）
    * itcast-haoke-manage-dubbo-server-ad（广告服务父工程）
      * itcast-haoke-manage-dubbo-server-ad-interface（广告服务接口层）
      * itcast-haoke-manage-dubbo-server-ad-service（广告服务业务实现层）
    * itcast-haoke-manage-dubbo-server-common（通用工程）
    * itcast-haoke-manage-dubbo-server-generator(MyBatis（Plus代码生成器）
    * itcast-haoke-manage-dubbo-server-house-resources（房源服务父工程）
      * itcast-haoke-manage-dubbo-server-house-resources-dubbo-interface（房源服务接口定义工程）
      * itcast-haoke-manage-dubbo-server-house-resources-dubbo-service（房源管理业务实现工程）



## 二、技术描述

### 2.1、服务端技术

* 阿里云OSS文件存储
* [MyBatis-Plus](https://baomidou.com/) 魂斗罗 MyBatis好兄弟
* [percona v5.7.23](https://www.percona.com/software/mysql-database) MySQL升级版
  * Percona为MySQL数据库服务器进行了改进，在功能和性能上较MySQL有着很显著的提升
  * 该版本提升了在高负载情况下的InnoDB的性能，为DBA提供一些非常有用的性能诊断工具
* [GraphQL](https://graphql.cn/) 用于描述复杂数据模型的一种查询语言，一种用于前后端数据查询方式的规范
  * 用人话说就是，后端适配前端，前端要啥就传啥，后端就给啥
  * [规范地址](https://spec.graphql.cn/)
  * [演示地址](http://graphql.cn/learn/schema/#type-system)
  * [查询的规范](https://graphql.cn/learn/queries/)
  * [GraphQL的Schema和类型规范](https://graphql.cn/learn/schema/)
  * [java实现:graphql-java](https://www.graphql-java.com/)
    * [github地址](https://github.com/graphql-java/graphql-java)
  * [Apollo Client](https://www.apollographql.com/docs/react/get-started/) 前端使用的GraphQL客户端

### 2.2、前端技术

* [ReactJS](https://reactjs.org/) 一个用于构建用户界面的JavaScript框架

* [UmiJS](https://umijs.org/zh/) 可插拔的企业级react应用框架
  * 读音：乌米 
  * 特点：
    * 插件化
      * umi 的整个生命周期都是插件化的，甚至其内部实现就是由大量插件组成，比如 pwa、按需加载、一键切换 preact、一键兼容 ie9 等等，都是由插件实现
    * 开箱即用
      * 你只需一个 umi 依赖就可启动开发，无需安装 react、preact、webpack、react-router、babel、jest 等等。
    * 约定式路由
      * 类 next.js 的约定式路由，无需再维护一份冗余的路由配置，支持权限、动态路由、嵌套路由等等
  * [安装参考01](https://note.youdao.com/s/ChmmULc)
