/**
 * 应用层
 * 相对于领域层,应用层是很薄的一层,应用层定义了软件要完成的任务,要尽量简单.
 * 它不包含任务业务规则或知识,为下一层的领域对象协助任务、委托工作.
 * 它没有反映业务情况的状态,但它可以具有反映用户或程序的某个任务的进展状态.
 * 对外 为展现层提供各种应用功能(service).
 * 对内 调用领域层（领域对象或领域服务）完成各种业务逻辑任务(task).
 * 另外,任务处理,日志监控类逻辑也可以在本层实现.
 **/
package com.wy.ddd.application;