package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Course;
import io.ims.backend.Models.Student;

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

        course.setDepartment(null);
        course.setStudents(null);

        generator.writeObject(course);
    }
}
