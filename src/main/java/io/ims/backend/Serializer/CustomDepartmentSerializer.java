package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Department;

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

        department.setCourses(null);
        department.setProfessors(null);
        department.setSubjects(null);

        generator.writeObject(department);
    }

}
