package com.mabel.springtest

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.beans.factory.BeanNameAware
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Service

@Service
class TestService(
    private val testComponent: TestComponent,
) : BeanNameAware, BeanFactoryAware, BeanPostProcessor, InitializingBean {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val users = mutableListOf<Int>()

    init {
        logger.info("init block users $users")
    } // bean initiation #createBeanInstance

    @Autowired
    private lateinit var testService2: TestService2

    @Value("\${application.userid}")
    private lateinit var userId: String // dependency injection #populateBean

    override fun setBeanName(name: String) {
        logger.info("setBeanName userid $userId users $users")
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        logger.info("setBeanFactory userId $userId users $users")
    }

    override fun afterPropertiesSet() {
        logger.info("afterPropertiesSet userId $userId users $users ")
    } // customize initialization #initize bean

    fun test() {
        logger.info("test test")
    }
}