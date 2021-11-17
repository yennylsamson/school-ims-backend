package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.*;

import java.io.IOException;

public class CustomSubjectSerializer extends StdSerializer<Subject> {
    public CustomSubjectSerializer() {
        this(null);
    }

    public CustomSubjectSerializer(Class<Subject> t) {
        super(t);
    }


    @Override
    public void serialize(
            Subject subject,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        generator.writeStartObject();
        generator.writeNumberField("subjectID", subject.getSubjectID());
        generator.writeStringField("subjectName", subject.getSubjectName());
        generator.writeStringField("subjectCode", subject.getSubjectCode());
        generator.writeStringField("units", subject.getUnits());
        generator.writeNumberField("lectureHours", subject.getLectureHours());
        generator.writeNumberField("labHours", subject.getLabHours());
        generator.writeFieldName("enrolledStudents");
        generator.writeStartArray();
        for (Student student : subject.getEnrolledStudents()) {
            generator.writeStartObject();
            generator.writeNumberField("userID", student.getUserID());
            generator.writeStringField("firstName", student.getFirstName());
            generator.writeStringField("lastName", student.getLastName());
            generator.writeStringField("yearLevel", student.getYearLevel());
            generator.writeStringField("section", student.getSection());
            generator.writeEndObject();
        }
        generator.writeEndArray();
        generator.writeFieldName("teachingProfessors");
        generator.writeStartArray();
        for (Professor professor : subject.getTeachingProfessors()) {
            generator.writeStartObject();
            generator.writeNumberField("userID", professor.getUserID());
            generator.writeStringField("firstName", professor.getFirstName());
            generator.writeStringField("lastName", professor.getLastName());
            generator.writeEndObject();
        }
        generator.writeEndArray();
        generator.writeFieldName("department");
        Department department = subject.getDepartment();
        generator.writeStartObject();
        generator.writeNumberField("departmentID", department.getDepartmentID());
        generator.writeStringField("departmentName", department.getDepartmentName());
        generator.writeStringField("departmentDean", department.getDepartmentDean());
        generator.writeEndObject();
        generator.writeEndObject();
    }
}
