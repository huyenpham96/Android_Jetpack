package com.utildev.androidjetpack.data.repository

import com.google.gson.JsonObject
import com.utildev.androidjetpack.data.local.dao.DBDao
import com.utildev.androidjetpack.data.local.model.UserEntity
import com.utildev.androidjetpack.data.remote.ApiService
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.RequestBody

class AppRepository(private val apiService: ApiService, private val dbDao: DBDao): Repository {
    override fun getMenu(pageSize: Int): Observable<JsonObject> = apiService.requestMenu(pageSize)

    override fun getQuestion(site: String, page: Int): Observable<JsonObject> = apiService.requestQuestion(site, page)

    override fun getAllSite(page: Int): Observable<JsonObject> = apiService.requestAllSite(page)

    override fun requestBody(body: RequestBody): Observable<JsonObject> = apiService.requestBody(body)

    override fun insert(userEntity: UserEntity) = dbDao.insertUser(userEntity)

    override fun getAllUser(): Flowable<MutableList<UserEntity>> = dbDao.getAllUser()
}