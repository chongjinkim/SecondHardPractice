package com.nepplus.secondhardpractice.remotedatasource

import com.nepplus.secondhardpractice.model.UserResponse
import com.nepplus.secondhardpractice.network.Client

//데이터 출저와 관계없이 동일 인터페이스로 db에 접속할 수 있게 만든게 repository 패턴
//데이터 로직을 분리, 중앙 집중처리 방식으로 일관되어 있는 인터페이스로 데이터에 접속
//클라이언트가 어떤 데이터를 사용할지 repository가 알아서 구분을 한다.
//단위 테스트를 통해 검증이 가능하다.
//새로운 데이터 로직 코드를 쉽게 추가할 수 있다.

interface GithubRepository {

    suspend fun couroutineGetUsers(query : String) : UserResponse
}

//client안에 githubapi 객체 생성.
//repository 메쏘드를 통해 viewmodel로 접근
class GithubRepositoryImpl(val client : Client) : GithubRepository {

    override suspend fun couroutineGetUsers(query: String): UserResponse {
        return client.githubAPI.couroutineGetUsers(query)
    }
}


