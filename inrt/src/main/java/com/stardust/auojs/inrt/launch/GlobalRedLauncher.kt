package com.stardust.auojs.inrt.launch

import android.annotation.SuppressLint
import com.stardust.app.GlobalAppContext

/**
 * Created by Stardust on 2018/3/21.
 */

@SuppressLint("StaticFieldLeak")
object GlobalRedLauncher : AssetsProjectLauncher("project", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalKuaiShouLauncher : AssetsProjectLauncher("kuaishou", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalDouYinLauncher : AssetsProjectLauncher("douyin", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalNotificationLuncher : AssetsProjectLauncher("notification", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalMaskLuncher : AssetsProjectLauncher("youpin", GlobalAppContext.get())


@SuppressLint("StaticFieldLeak")
object GlobalAllLauncher : AssetsProjectLauncher("all", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalDouGuaGuaLauncher : AssetsProjectLauncher("douguagua", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalHuoShanLauncher : AssetsProjectLauncher("huoshan", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalJuKanDianLauncher : AssetsProjectLauncher("jukandian", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalQuTouTiaoLauncher : AssetsProjectLauncher("qutoutiao", GlobalAppContext.get())

@SuppressLint("StaticFieldLeak")
object GlobalShuaBaoLauncher : AssetsProjectLauncher("shuabao", GlobalAppContext.get())
