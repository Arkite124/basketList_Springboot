package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {
    int deleteByUserId(Integer userId); //회원 2차 과정 완료 안하면 자동삭제 하도록 서비스에 넣을 예정)
    int insert(Users record); //회원가입 1차 -> 2차 완료 안하면 1차과정 자동 삭제되도록 서비스에서 구현할 예정)
    Users selectByUserId(Integer userId); //특정 유저 조회
    int updateByIdSelective(Users users); //유저정보 업데이트(선택적이니 이게 더 적절할듯)
    Users selectUserAndUserDetailByUserId(Integer userId);
    Users selectUserByUserNickName(String userNickName); //닉네임으로 유저 조회할때 -> 파라미터로 써도 되고 유니크라서 중복체크용으로 써도 됨
    String checkUserName(String userName); //아이디 중복체크용
    String checkUserNickName(String userNickName);
}