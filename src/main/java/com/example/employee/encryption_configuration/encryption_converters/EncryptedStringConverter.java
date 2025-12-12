package com.example.employee.encryption_configuration.encryption_converters;

import com.example.employee.encryption_configuration.encryption_util.EncryptionUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EncryptedStringConverter implements AttributeConverter<String,String> {
    @Override
    public String convertToDatabaseColumn(String dbData) {
        try{
            return dbData==null?null: EncryptionUtil.encrypt(dbData);
        }
        catch(Exception e){
            throw new RuntimeException("Failed to encrypt"+e);
        }
    }

    @Override
    public String convertToEntityAttribute(String attribute) {
        try{
            return attribute==null?null:EncryptionUtil.decrypt(attribute);
        }
        catch(Exception e){
            throw new RuntimeException("Failed to decrypt"+e);
        }
    }
}
