# **basketList의 서버단 백앤드 목적으로 설계한 Git-Repository 입니다.**

-수업시 바닐라 예시 JSON과 자바 스크립트로만 했던 장바구니 담기
newProjects를 체계적으로 구성하기 위한 재빌드업 및 재구성입니다.
-개인진행 프로젝트라 올라오는 주기가 느릴 수 있습니다.
-팀프로젝트에서 써보지 않았던 MyBatis와 OracleDB를 사용하기 위해 진행하는 개인프로젝트 입니다.

### 이미지 사용 관련 안내

본 프로젝트에 사용된 모든 상품 이미지는 구글/네이버 쇼핑같은 쇼핑사이트에서 수집된 공개 상품 홍보 이미지로,
**비상업적 포트폴리오 및 학습용 목적**으로만 사용되었으며,
상업적 목적이나 유료 서비스에 사용되지 않습니다.

이미지에 대한 저작권은 각 상품 제공처 및 브랜드에 귀속됩니다.
문제될 시 메일(ghkddudwnd@naver.com(자주 확인) 
/ ghkddudwnd@gmail.com(거의 확인 안함))로 
어떤 이미지가 문제되시는지 연락주시면 해당이미지 확인 후 수정하도록 하겠습니다.

커밋 내역 작성
1. first Commit : MyBatisGenerator를 이용한 기초 Dto, Dao, Mapper를 기초 제작
-상품 이미지는 구글/네이버 및 기타 홍보용 사진자료에서 가져온 것입니다. 
2. 이미지 이동 : Springboot에서 이미지 파일 삭제 
3. data : 샘플데이터 추가 및 형식 변경 && 기초 구문 추가
4. Readme : Readme에 메일주소 추가
5. Test : leftjoin 을 쓰는 쿼리를 추가하고 테스트 환경, Gradle 무한동의 오류 잡는다고 늦어짐
6. Gradle : 쿼리구현 & 작동을 끝마친 상태에서 gradle 때문에 test 수신자체가 안됨
7. UserDto : UserDto(user+userDetails) 유저 내역 조회 구현 및 간단 테스트
8. register : register(회원가입) & keyWord로 상품 검색, 모든 상품 조회, 카테고리별 조회,
상품별 가격 (수량*가격=selectedPrice) , 총 가격 (totalPrice) 쿼리구문으로 따로 구현,
상품 ID로 특정상품 조회와 상품의 수량조절(updateQuantity), 장바구니에 상품 담기등 장바구니 기본 서비스단 및 Mapper 제작  
추가로 SampleDB는 상품 추가,장바구니 넣은 날짜 랜덤화 까지 구현함
한번에 push 하는 습관은 안좋지만 집중한다고 자꾸 잊어버림... 다음에는 위시리스트 확인 및 구현 예정
다음에 로그인/로그아웃 기능을 구현 후에 마지막에 RestController로 RESTful API로 구성해보겠음
9. login : login 구현 (logout은 자동으로 되거나 한줄코드 추가하면 될듯... session.invalidate 같은거...) 
비밀번호 암호화, Controller 구조 기초, LoginDto는 작성했지만, 마지막에 jwt 추가하는 정점을 찍을때나 쓸듯
wishListMapper만 추가, product Paging 하는 것에서 막힘(MyBatis는 기본적으로 Page를 지원하지 않음)
로그인 구조는 React 에서는 좋지 않은 구조지만 임시로 session+cookie로 구현할 예정(jwt가 좋지만... 그건 나중에ㅠ)
10. Service : service 구조는 거의 완성 되감, Mapper 에서 테스트한걸 바탕으로 넣을 예정 완성후 
Controller를 통해 하나하나씩 구현해나갈 예정, 부족하다고 생각되는건 Mapper 부터 보충해나갈 예정
11. Update : 각 데이터베이스에 대한걸 Update(modify)하는 것중에 User,UserDetails를 합친 UserDto가 어려우서 거기서 고전중
자야되니 임시 커밋, 애초에 Users,UserDetails를 분리해놓은 이유는 따로 조회하기 위함이었는데 힘들어지는거 같은 느낌...?
User,UserDetails를 묶은 UserDto만 업데이트 객체를 구현하고 나면 나머지는 단독 업데이트라 업데이트 할만할듯 함
12. Register : ProductList 를 제외한 전 카테고리 Controller 까지 구현, 아직 purchase(구매,모의) 는 계획에 없으므로 제외
회원 가입시 중복체크 Controller 만듬, Login한 user의 UserDto 불러오는 메커니즘 수정
13. Product : ProductList 기능 거의 다 끝냄, 검색기능이 정상적으로 작동하는거 같지 않아서 수정중
모자란 기능 및 불필요한 쿼리문,서비스문 수정 및 제거