package com.example.employee.encryption_configuration.encryption_converters;

import com.example.employee.encryption_configuration.encryption_util.EncryptionUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter
public class EncryptedLocalDateConverter implements AttributeConverter<LocalDate,String> {
   private static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    @Override
    public String convertToDatabaseColumn(LocalDate dbData) {
        try{
            if(dbData==null)
                return null;
            return EncryptionUtil.encrypt(dbData.format(FORMATTER));
        }
        catch(Exception e){
            throw new RuntimeException("LocalDate failed to encrypt"+e);
        }
    }

    @Override
    public LocalDate convertToEntityAttribute(String attribute) {
        try{
            if(attribute==null)
                return null;
            String decrypt = EncryptionUtil.decrypt(attribute);
            return LocalDate.parse(decrypt,FORMATTER);
        }
        catch(Exception e){
            throw new RuntimeException("LocalDate failed to decrypt"+e);
        }
    }
}
