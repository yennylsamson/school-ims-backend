package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomStudentSerializer extends StdSerializer<Student> {

    private Student student;
    private JsonGenerator jsonGenerator;
    private SerializerProvider serializerProvider;

    public CustomStudentSerializer() {
        this(null);
    }

    public CustomStudentSerializer(Class<Student> t) {
        super(t);
    }


    @Override
    public void serialize(
            Student student,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

//        generator.writeStartObject();
//        generator.writeNumberField("userID", student.getUserID());
//        generator.writeEndObject();

        student.setJoinedStudentSubjects(null);
        student.setActivities(null);
        student.setCourse(null);

        generator.writeObject(student);
    }
}