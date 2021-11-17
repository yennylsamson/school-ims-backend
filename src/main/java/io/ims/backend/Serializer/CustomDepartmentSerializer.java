package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.*;

import java.io.IOException;

public class CustomDepartmentSerializer extends StdSerializer<Department> {
    public CustomDepartmentSerializer() {
        this(null);
    }

    public CustomDepartmentSerializer(Class<Department> t) {
        super(t);
    }

    @Override
    public void serialize(
            Department department,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        generator.writeStartObject();
            generator.writeNumberField("departmentID", department.getDepartmentID());
            generator.writeStringField("departmentName", department.getDepartmentName());
            generator.writeStringField("departmentDean", department.getDepartmentDean());
            generator.writeFieldName("professors");
                generator.writeStartArray();
                    for (Professor professor : department.getProfessors()) {
                        generator.writeStartObject();
                            generator.writeNumberField("userID", professor.getUserID());
                            generator.writeStringField("firstName", professor.getFirstName());
                            generator.writeStringField("lastName", professor.getLastName());
                        generator.writeEndObject();
                    }
                generator.writeEndArray();
            generator.writeFieldName("courses");
                generator.writeStartArray();
                for (Course course : department.getCourses()) {
                    generator.writeStartObject();
                        generator.writeNumberField("courseID", course.getCourseID());
                        generator.writeStringField("courseName", course.getCourseName());
                        generator.writeStringField("courseCode", course.getCourseCode());
                        generator.writeStringField("chairperson", course.getChairperson());
                    generator.writeEndObject();
                }
                generator.writeEndArray();
            generator.writeFieldName("subjects");
                generator.writeStartArray();
                for (Subject subject : department.getSubjects()) {
                    generator.writeStartObject();
                        generator.writeNumberField("subjectID", subject.getSubjectID());
                        generator.writeStringField("subjectName", subject.getSubjectName());
                        generator.writeStringField("subjectCode", subject.getSubjectCode());
                        generator.writeStringField("units", subject.getUnits());
                        generator.writeNumberField("lectureHours", subject.getLectureHours());
                        generator.writeNumberField("labHours", subject.getLabHours());
                    generator.writeEndObject();
                }
                generator.writeEndArray();
        generator.writeEndObject();
    }

}
