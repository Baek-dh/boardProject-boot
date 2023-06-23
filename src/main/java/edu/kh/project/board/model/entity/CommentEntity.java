package edu.kh.project.board.model.entity;

import edu.kh.project.common.utility.DateConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@Entity(name = "COMMENT")
//@SequenceGenerator(name="SEQ_COMMENT_NO",
//	sequenceName="SEQ_COMMENT_NO", 
//	initialValue=2000,
//	allocationSize=1)  
public class CommentEntity {
	
//	@Id
//	@Column(name="COMMENT_NO")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMENT_NO")
//    private int commentNo;
//	
//	@Column(name="COMMENT_CONTENT", length=2000, nullable = false)
//    private String commentContent;
//	
//	@Column(name = "C_CREATE_DATE", nullable = false, columnDefinition = "DATE DEFAULT SYSDATE")
//	@Convert(converter = DateConverter.class)
//    private String commentCreateDate;
//	
//	@Column(name="BOARD_NO", nullable = false)
//    private int boardNo;
//	
//	@ManyToOne
////	 @JoinColumn(name="MEMBER_NO",referencedColumnName = "MEMBER_NO")
//	 @JoinColumn(name="MEMBER_NO")
//    private int memberNo;
//	
//	@Column(name = "COMMENT_DEL_FL", length=1, nullable = false, columnDefinition = "CHAR(1) CHECK COMMENT_DEL_FL IN ('Y', 'N') DEFAULT 'N'")
//    private String commentDeleteFlag;
//	
////	@JoinColumn(name="PARENT_NO", referencedColumnName =  "COMMENT_NO")
//	@JoinColumn(name="COMMENT_NO")
//    private int parentNo;
//    
////    @JoinColumn(name="MEMBER_NICKNAME",referencedColumnName = "MEMBER_NICKNAME")
//	@JoinColumn(name="MEMBER_NO")
//    private String memberNickname;
//    
//    @Column(name="PROFILE_IMG",nullable = false)
//    private String profileImage;
}
