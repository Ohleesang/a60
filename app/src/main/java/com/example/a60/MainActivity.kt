package com.example.a60

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun countDivisor(n : Int): Int{
                var answer = 0
                var length = Math.sqrt(n.toDouble()).toInt()

                for(i in 1..length){
                    //제곱근을 이용하면 1~n 복잡도를 줄일수있다
                    if(n%i==0) {
                        answer++
                        if(n/i != i){//추가로 구해지는 약수... 제곱근 전까지의 약수를 한번 나뉘어서 구한다
                            answer++
                        }
                    }
                }
                return answer
            }
            fun solution(number: Int, limit: Int, power: Int): Int {
                var answer: Int = 0
                //number : 기사단원의 수
                //limit : 공격력 제한수치
                //power : 사용할 무기의 공격력

                //1. 기사단원 수만큼의 약수의 개수를 저장하는 배열 선언하기
                var powerArray = Array<Int>(number,{0})
                for(i in 0..number-1){
                    //1~number 까지의 약수의 개수를 구한다
                    powerArray[i]=countDivisor(i+1)
                    //2. 공격력 제한 수치(limit)를 넘는가를 확인
                    //3. 만약 공격력이 limit를 넘는다면 power 값으로 변경
                    if(powerArray[i]>limit) powerArray[i]=power
                }
                //4. 각 결과값들을 합쳐서 return
                answer=powerArray.sumOf{it.toInt()}

                return answer
            }
        }
        val a =Solution()
        a.solution(5,3,2)//10
        a.solution(10,3,2)//21
    }
}