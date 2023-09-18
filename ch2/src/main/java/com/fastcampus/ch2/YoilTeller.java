package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

//년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
    @RequestMapping("/getYoil")
    public String main(@ModelAttribute MyDate myDate, Model model) throws IOException {

        // 2. 작업 - 요일을 계산
        char yoil = getYoil(myDate);

        //작업한 결과를 Model에 저장
//        model.addAttribute("myDate", myDate);//생략시 타입 첫글자 소문자
//        model.addAttribute("year", myDate.getYear());
//        model.addAttribute("month", myDate.getMonth());
//        model.addAttribute("day", myDate.getDay());
//        model.addAttribute("yoil", yoil);

        return "yoil";// yoil.html
    }

    @ModelAttribute("yoil")//yoil 이라는 이름으로 저장, Controller가 model에 담음.
    private static char getYoil(MyDate myDate) {
        Calendar cal = Calendar.getInstance();//현재 날짜와 시간을 갖는 cal
        cal.clear();//초기화
        cal.set(myDate.getYear(), myDate.getMonth()-1, myDate.getDay());// 월은 0부터 11이기 때문에 1을 빼줘야함

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);// 1~7을 반환. 1: 일요일, 2 : 월요일
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);//1~7 -> 0~6
        return yoil;
    }
}
/*
* @ModelAttribute
* 매개변수
* 참조형 변수에만 가능함

* 
* 메서드
* Controller 에서 @ModelAttribute 붙은 메서드 자동으로 호출해서 model에 저장, view 에서 사용 가능
*/