package org.scoula.member.mapper;

import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;

public interface MemberMapper {

    MemberVO get(String username); // join 필요

    MemberVO findByUsername(String username); // id 중복 체크

    int insert(MemberVO member); // 회원 정보 추가

    int insertAuth(AuthVO auth); // 회원 권한 추가

    int update(MemberVO member);

    int updatePassword(ChangePasswordDTO changePasswordDTO);

}
