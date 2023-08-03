package com.example.model_common.common

import android.util.Log


/**
 * 日志输出类
 */
object ELog {

    var className: String? = null
    var methodName: String? = null
    var lineNumber: Int? = 0
    var mDebuggable: Boolean = false
    private fun isDebuggable(): Boolean {
        return ELog.mDebuggable
    }

    fun createLog(log: String): String {
        var stringBuilder = StringBuilder()
        stringBuilder.append("===").append(methodName)
            .append("(")
            .append(className)
            .append(":")
            .append(lineNumber)
            .append(")===")
            .append(log);
        return stringBuilder.toString()
    }

    fun setDebuggable(debuggable: Boolean) {
        ELog.mDebuggable = debuggable
    }

    //根据获取到的堆栈跟踪信息，得到当前调用这个类的类名、方法名以及行数
    private fun getName(stackTraceElements: Array<StackTraceElement>) {
        className = stackTraceElements[1].fileName
        methodName = stackTraceElements[1].methodName
        lineNumber = stackTraceElements[1].lineNumber
    }

    fun e(msg: String) {
        if (mDebuggable) return
        //获取堆栈信息
        ELog.getName(Throwable().stackTrace)
        Log.e(className, createLog(msg))
    }

    fun d(msg: String?) {
        if (!isDebuggable()) return
        getName(Throwable().stackTrace)
        Log.d(className, createLog(msg!!))
    }

    fun i(msg: String?) {
        if (!isDebuggable()) return
        getName(Throwable().stackTrace)
        Log.i(className, createLog(msg!!))
    }

    fun v(msg: String?) {
        if (!isDebuggable()) return
        getName(Throwable().stackTrace)
        Log.v(className, createLog(msg!!))
    }

    fun w(msg: String?) {
        if (!isDebuggable()) return
        getName(Throwable().stackTrace)
        Log.w(className, createLog(msg!!))
    }


}