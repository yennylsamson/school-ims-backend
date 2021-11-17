package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomStudentSerializer extends StdSerializer<Student> {

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

        generator.writeStartObject();
            generator.writeNumberField("userID", student.getUserID());
            generator.writeStringField("email", student.getEmail());
            generator.writeStringField("password", student.getPassword());
            generator.writeStringField("userRole", student.getUserRole());
            generator.writeStringField("firstName", student.getFirstName());
            generator.writeStringField("lastName", student.getLastName());
            generator.writeStringField("gender", student.getGender());
            generator.writeStringField("birthDate", student.getBirthDate().toString());
            generator.writeStringField("homeAddress", student.getHomeAddress());
            generator.writeStringField("contactNumber", student.getContactNumber());
            generator.writeStringField("civilStatus", student.getCivilStatus());
            generator.writeStringField("yearLevel", student.getYearLevel());
            generator.writeStringField("section", student.getSection());
            generator.writeFieldName("joinedStudentSubjects");
            generator.writeStartArray();
            for (Subject subject : student.getJoinedStudentSubjects()) {
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
            generator.writeFieldName("activities");
            generator.writeStartArray();
            for (Activity activity : student.getActivities()) {
                generator.writeStartObject();
                generator.writeNumberField("activityID", activity.getActivityID());
                generator.writeStringField("subjectName", activity.getSubject().getSubjectName());
                generator.writeStringField("activityName", activity.getActivityName());
                generator.writeStringField("activityType", activity.getActivityType());
                generator.writeNumberField("studentScore", activity.getStudentScore());
                generator.writeNumberField("totalScore", activity.getTotalScore());
                generator.writeStringField("studentName", activity.getStudent().getFirstName() + " " + activity.getStudent().getLastName());
                generator.writeStringField("professorName", activity.getProfessor().getFirstName() + " " + activity.getProfessor().getLastName());
                generator.writeEndObject();
            }
            generator.writeEndArray();
            generator.writeFieldName("course");
                    Course course = student.getCourse();
                    generator.writeStartObject();
                        generator.writeNumberField("courseID", course.getCourseID());
                        generator.writeStringField("courseName", course.getCourseName());
                        generator.writeStringField("courseCode", course.getCourseCode());
                        generator.writeStringField("chairperson", course.getChairperson());
                    generator.writeEndObject();
        generator.writeEndObject();
    }
}