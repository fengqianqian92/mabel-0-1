package com.mabel

class Singleton private constructor() {
    companion object {
        private val singleton = Singleton()
        fun getSingleton() = singleton
    }
}

class Singleton2 private constructor() {
    companion object {
        private var singleton2: Singleton2? = null

        @Synchronized
        fun getSingleton(): Singleton2 {
            if (singleton2 == null) {
                singleton2 = Singleton2()
            }
            return singleton2 as Singleton2
        }
    }
}

class Singleton3 private constructor() {
    companion object {
        private var singleon3: Singleton3? = null
        fun getSingleton(): Singleton3 {
            if (singleon3 == null) {
                synchronized(Singleton3::class.java) {
                    if (singleon3 == null) {
                        singleon3 = Singleton3()
                    }
                }
            }
            return singleon3 as Singleton3
        }
    }
}

enum class Singleton4 {
    INSTANCE;
}