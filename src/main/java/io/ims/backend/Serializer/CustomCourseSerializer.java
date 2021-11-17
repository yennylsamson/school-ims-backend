package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.*;

import java.io.IOException;

public class CustomCourseSerializer extends StdSerializer<Course> {
    public CustomCourseSerializer() {
        this(null);
    }

    public CustomCourseSerializer(Class<Course> t) {
        super(t);
    }


    @Override
    public void serialize(
            Course course,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        generator.writeStartObject();
            generator.writeNumberField("courseID", course.getCourseID());
            generator.writeStringField("courseName", course.getCourseName());
            generator.writeStringField("courseCode", course.getCourseCode());
            generator.writeStringField("chairperson", course.getChairperson());
            generator.writeFieldName("students");
            generator.writeStartArray();
            for (Student student : course.getStudents()) {
                generator.writeStartObject();
                    generator.writeNumberField("userID", student.getUserID());
                    generator.writeStringField("firstName", student.getFirstName());
                    generator.writeStringField("lastName", student.getLastName());
                    generator.writeStringField("yearLevel", student.getYearLevel());
                    generator.writeStringField("section", student.getSection());
                generator.writeEndObject();
            }
            generator.writeEndArray();
            generator.writeFieldName("department");
                Department department = course.getDepartment();
                generator.writeStartObject();
                    generator.writeNumberField("departmentID", department.getDepartmentID());
                    generator.writeStringField("departmentName", department.getDepartmentName());
                    generator.writeStringField("departmentDean", department.getDepartmentDean());
                generator.writeEndObject();
        generator.writeEndObject();

    }
}
