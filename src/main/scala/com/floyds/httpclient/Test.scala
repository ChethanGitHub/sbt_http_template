package com.floyds.httpclient


import org.apache.http.client.methods.{HttpGet, HttpPost}
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils


object Test extends App {
  val httpClient = HttpClients.createDefault()

  case class Credential(usr: String, pwd: String)

  //  "https://httpbin.org/get"
  def doget(urs: String): String = {
    val request = new HttpGet(urs)
    // add request headers
    request.addHeader("custom-key", "mkyong")

    val response = httpClient.execute(request)
    // Get HttpResponse Status
    println(response.getProtocolVersion) // HTTP/1.1
    println(response.getStatusLine.getStatusCode) // 200
    println(response.getStatusLine.getReasonPhrase) // OK
    println(response.getStatusLine.toString) // HTTP/1.1 200 OK

    val entity = response.getEntity
    // return it as a String
    val result = EntityUtils.toString(entity)
    println(result)

    result
  }


  def doPost(url: String, auth:Credential): String = {
    val request = new HttpPost(url)
    // add request headers
    request.addHeader("custom-key", "mkyong")

    val response = httpClient.execute(request)
    // Get HttpResponse Status
    println(response.getProtocolVersion) // HTTP/1.1
    println(response.getStatusLine.getStatusCode) // 200
    println(response.getStatusLine.getReasonPhrase) // OK
    println(response.getStatusLine.toString) // HTTP/1.1 200 OK

    val entity = response.getEntity
    // return it as a String
    val result = EntityUtils.toString(entity)
    println(result)

    result
  }

  val cred = Credential("user","pwd")
  doPost("google.com",cred)
}
