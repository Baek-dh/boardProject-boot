package edu.kh.project.myPage.model.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {
	
	/** 회원 정보 수정 DAO
	 * @param updateMember
	 * @return result
	 */
	int updateInfo(Member updateMember);


	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	String selectEncPw(int memberNo);


	/** 비밀번호 변경
	 * @param member
	 * @return result
	 */
	int changePw(Member memberNo);


	/** 회원 탈퇴 DAO
	 * @param memberNo
	 * @return result
	 */
	int secession(int memberNo);


	/** 프로필 이미지 수정
	 * @param loginMember
	 * @return result
	 */
	int updateProfileImage(Member loginMember);
	
}
