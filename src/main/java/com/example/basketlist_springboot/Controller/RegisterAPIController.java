package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.ConfirmPwDto;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Service.RegisterService;
import com.example.basketlist_springboot.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/userStatus/register")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class RegisterAPIController {
    private final RegisterService registerService;
    private final UsersService usersService;

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserDto dto) {
        UserDto newUserDto=usersService.registerUsers(dto);
        if(newUserDto==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원가입에 실패했습니다.");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/check-password")
    public ResponseEntity<Map<String,Object>> confirmPassword(@RequestBody ConfirmPwDto dto) {
        Boolean checkPw=registerService.checkConfirmPassword(dto.getPassword(),dto.getConfirmPassword());
        Map<String,Object> resultMap=new HashMap<>();
        if(checkPw==null) {
            resultMap.put("checkPw",false);
            resultMap.put("pwMessage","비밀번호가 입력되지 않았습니다.");
            return ResponseEntity.ok(resultMap);
        }
        if(dto.getPassword().length()<=8){
            resultMap.put("checkPw",false);
            resultMap.put("pwMessage","비밀번호는 8자리 이상으로 입력해야 합니다.");
            return ResponseEntity.ok(resultMap);
        }
        if(!checkPw) {
            resultMap.put("checkPw",false);
            resultMap.put("pwMessage","입력된 비밀번호가 일치하지 않습니다.");
            return ResponseEntity.ok(resultMap);
        }
        resultMap.put("checkPw",true);
        resultMap.put("pwMessage","비밀번호 확인이 완료되었습니다.");
        return ResponseEntity.ok(resultMap);
    }

    @PostMapping("/check-userName")
    public ResponseEntity<Map<String,Object>> userName(@RequestBody String userName) {
       Boolean checkUName=registerService.checkDuplicateUsername(userName);
        Map<String,Object> resultMap=new HashMap<>();
       if(checkUName==null) {
           resultMap.put("checkName",false);
           resultMap.put("nameMessage","입력된 아이디가 없습니다.");
           return ResponseEntity.ok(resultMap);
       }
       if(!checkUName) {
           resultMap.put("checkName",false);
           resultMap.put("nameMessage","이미 같은 이름의 아이디가 존재합니다.");
           return ResponseEntity.ok(resultMap);
       }
       if(userName.length()<6) {
           resultMap.put("checkName",false);
           resultMap.put("nameMessage","아이디는 6자가 넘어야 합니다.");
           return ResponseEntity.ok(resultMap);
       }
        resultMap.put("checkName",true);
        resultMap.put("nameMessage","사용가능한 아이디입니다.");
        return ResponseEntity.ok(resultMap);
    }

    @PostMapping("/check-email")
    public ResponseEntity<Map<String,Object>> email(@RequestBody String email) {
        Boolean checkEmail=registerService.checkDuplicateEmail(email);
        Map<String,Object> resultMap=new HashMap<>();
        if(checkEmail==null) {
            resultMap.put("checkEmail",false);
            resultMap.put("nameMessage","입력된 이메일이 없습니다.");
            return ResponseEntity.ok(resultMap);
        }
        if(!checkEmail) {
            resultMap.put("checkEmail",false);
            resultMap.put("nameMessage","이미 같은 이름의 이메일 주소가 있습니다.");
            return ResponseEntity.ok(resultMap);
        }
        resultMap.put("checkEmail",true);
        resultMap.put("nameMessage","사용가능한 이메일 주소입니다.");
        return ResponseEntity.ok(resultMap);
    }
    @PostMapping("/check-phone")
    public ResponseEntity<Map<String,Object>> phone(@RequestBody String phone) {
        Boolean checkPhoneNum=registerService.checkDuplicatePhoneNumber(phone);
        Map<String,Object> resultMap=new HashMap<>();
        if(checkPhoneNum==null) {
            resultMap.put("checkPhone",false);
            resultMap.put("phoneMessage","입력된 번호가 없습니다.");
            return ResponseEntity.ok(resultMap);
        }
        if(!checkPhoneNum) {
            resultMap.put("checkPhone",false);
            resultMap.put("phoneMessage","이미 등록된 번호가 있습니다.");
            return ResponseEntity.ok(resultMap);
        }
        if(phone.length()<11 || !phone.startsWith("010") || phone.length()>11) {
            resultMap.put("checkPhone",false);
            resultMap.put("phoneMessage","올바른 형식의 번호가 아닙니다. 다른번호 이용시 관리자에게 문의 바랍니다.");
            return ResponseEntity.ok(resultMap);
        }
        resultMap.put("checkPhone",true);
        resultMap.put("phoneMessage","사용가능한 휴대폰 번호입니다.");
        return ResponseEntity.ok(resultMap);
    }
    @GetMapping("/check-nickname")
    public ResponseEntity<Map<String,Object>> checkNickname(@RequestParam String nickname) {
        Boolean checkedNickname=registerService.checkDuplicateUserNickname(nickname);
        Map<String,Object> resultMap=new HashMap<>();
        if(nickname==null) {
            resultMap.put("checkNick",false);
            resultMap.put("nickMessage","입력된 닉네임이 없습니다.");
            return ResponseEntity.ok(resultMap);
        }
        if(nickname.length()<3){
            resultMap.put("checkNick",false);
            resultMap.put("nickMessage","닉네임은 3자 이상으로 설정하셔야 합니다.");
            return ResponseEntity.ok(resultMap);
        }
        if(!checkedNickname) {
            resultMap.put("checkNick",false);
            resultMap.put("nickMessage","이미 존재하는 닉네임입니다.");
            return ResponseEntity.ok(resultMap);
        }
        resultMap.put("checkNick",true);
        resultMap.put("nickMessage","사용가능한 닉네임입니다.");
        return ResponseEntity.ok(resultMap);
    }
    @PostMapping("/check-privacyAgreements")
    public ResponseEntity<Map<String,Object>> checkAgreements(@RequestBody Integer privacyAgreements) {
        Boolean checkedAgreements=registerService.checkPrivacyAgreement(privacyAgreements);
        Map<String,Object> resultMap=new HashMap<>();
        if(checkedAgreements==null || !checkedAgreements) {
            resultMap.put("isAgree",false);
            resultMap.put("agreeMessage","개인정보 이용 동의에 동의하지 않으시면 회원가입이 불가합니다.");
            return ResponseEntity.ok(resultMap);
        }else if(privacyAgreements==null) {
            resultMap.put("isAgree",false);
            resultMap.put("agreeMessage","개인정보 동의에 대한 내용을 보고 동의 체크박스 표시해주세요!");
            return ResponseEntity.ok(resultMap);
        }
        resultMap.put("isAgree",true);
        resultMap.put("agreeMessage","개인정보 이용에 동의해주셔서 감사합니다.");
        return ResponseEntity.ok(resultMap);
    }
}
