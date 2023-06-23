package edu.kh.project.common.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DateConverter implements AttributeConverter<String, Date>{

    
    /*String to Date (Client -> DB) */
	@Override
	public Date convertToDatabaseColumn(String attribute) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
        try {
            date = sdf.parse(attribute);
        } catch (ParseException e) {
        	System.out.println("Date 타입 변환 실패");
        }
        return date;
	}

	/*Date to String (DB -> Client)*/
	@Override
	public String convertToEntityAttribute(Date dbData) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일 HH시 mm분 ss초");
		
		if(dbData != null) {
            return sdf.format(dbData);
        }else {
            return null;
        }
	}

	
}
