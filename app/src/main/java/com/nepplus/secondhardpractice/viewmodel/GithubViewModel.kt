package com.nepplus.secondhardpractice.viewmodel

import androidx.lifecycle.*
import com.nepplus.secondhardpractice.model.UserResponse
import com.nepplus.secondhardpractice.remotedatasource.GithubRepository
import com.nepplus.secondhardpractice.remotedatasource.GithubRepositoryImpl

class GithubViewModel (private val repository : GithubRepository) : ViewModel(){

    private val _user = MutableLiveData("")
//livedata 세팅
//githubrepository에 repositoory에 있는 함수를 통해, couroutinegetUsers를 불러와서 : UserResponse로 리턴값하도록
//메서드를 생성한 것을 livedata에 emit시킨다.

    val user : LiveData<UserResponse> = Transformations.switchMap(_user){
        if (!it.isNullOrEmpty()){
            liveData{
                emit(
                    repository.couroutineGetUsers(it)
                )
            }
        }
        else{
            liveData { emit(UserResponse()) }
        }
    }

    fun setUser(query : String){
        _user.value = query
    }

}