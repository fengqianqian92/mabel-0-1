//package com.example.mabel
//
//import org.springframework.beans.factory.BeanFactory
//import org.springframework.beans.factory.BeanFactoryAware
//import org.springframework.beans.factory.BeanNameAware
//import org.springframework.beans.factory.InitializingBean
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.beans.factory.config.BeanPostProcessor
//import org.springframework.stereotype.Service
//
//@Service
//class Test() : BeanNameAware, BeanFactoryAware, BeanPostProcessor, InitializingBean {
//    private val userList = mutableListOf<String>()
//
//    @Value("\${application.userid}")
//    private val userid: String? = null
//
//    init {
//        println("init block userid $userid")
//    }
//
//    override fun setBeanName(name: String) {
//        println("setBeanName userid $userid $name")
//    }
//
//    override fun setBeanFactory(beanFactory: BeanFactory) {
//        println("setBeanFactory $beanFactory")
//    }
//
//    override fun afterPropertiesSet() {
//        println("afterPropertiesSet userlist: $userList userid: $userid")
//    }
//}
//
////@Service
////class Test2(
////    @Value("\${application.userid}")
////    private val userid: String? = null
////) : BeanNameAware, BeanFactoryAware, BeanPostProcessor, InitializingBean {
////    private val userList = mutableListOf<String>()
////
////    init {
////        println("init block userid $userid")
////    }
////
////    override fun setBeanName(name: String) {
////        println("setBeanName userid $userid $name")
////    }
////
////    override fun setBeanFactory(beanFactory: BeanFactory) {
////        println("setBeanFactory $beanFactory")
////    }
////
////    override fun afterPropertiesSet() {
////        println("afterPropertiesSet userlist: $userList userid: $userid")
////    }
////}
//
//class Test3() {
//    public lateinit var a: String
//
//    fun test() {
//        a= "hello world"
//    }
//}