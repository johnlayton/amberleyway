package com.github.johnlayton.soap.service.sal.client

import com.github.johnlayton.soap.service.api.model.DemoService
import com.github.johnlayton.soap.service.sal.model.DemoRequest
import com.github.johnlayton.soap.service.sal.model.DemoResponse
import reactor.core.publisher.Mono

//@Component
//class DemoWebClient(address: String) : DemoClient {
class DemoWebClient(private val demoService : DemoService) : DemoClient {

//    val client = WebClient.builder().baseUrl(address).build();

    override fun sayHello(request: DemoRequest): Mono<DemoResponse> {
        return Mono.just(demoService.sayHello(request.let {
            com.github.johnlayton.soap.service.api.model.DemoRequest().apply {
                id = it.id
                name = it.name
            }
        }).let {
            DemoResponse(it.id, it.name)
        })
//        return client.post()
//                .bodyValue(request)
//                .retrieve()
//                .bodyToMono(DemoResponse::class.java)
    }

}