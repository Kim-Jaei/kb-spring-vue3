package org.scoula.member.service;

import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;

public interface MemberService {
    boolean checkDuplicate(String username); // id 중복 체크 : findByUsername()

    MemberDTO get(String username); // join 결과 리턴, 상세보기

    MemberDTO join(MemberJoinDTO member);  // get() 메서드 받아서 결과를 MemberDTO로

    MemberDTO update(MemberUpdateDTO member);

    void changePassword(ChangePasswordDTO changePassword);
}
