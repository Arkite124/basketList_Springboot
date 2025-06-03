package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsMapper {
    int insert(UserDetails userDetails); //회원가입 2차절차 Not Null이 대부분이라 이걸 쓸듯
    UserDetails selectUserDetailsByDetailUserId(Integer detailUserId);
    int updateUserDetailsSelective(UserDetails userDetails);
    Integer checkUserEmail(String Email); //이메일 중복체크용
    Integer checkUserPhone(String Phone); //핸드폰 번호 중복체크용
    Integer checkPrivacyAgreement(int PrivacyAgreement); //개인정보 이용 동의 -> 무조건 1이어야 함 아니면 회원 이용을 못함
}