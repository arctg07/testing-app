package com.example.testing.mapper;

import com.example.testing.config.MapperConfig;
import com.example.testing.database.entity.Question;
import com.example.testing.model.QuestionRequest;
import com.example.testing.model.QuestionWithOptions;
import com.example.testing.model.TestQuestion;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author Iurii Ivanov
 */

@Mapper(config = MapperConfig.class)
public interface QuestionMapper {

    Question toEntity(QuestionRequest request);

    Question toEntity(QuestionWithOptions request);

    @Mapping(target = "options", source = "answerOptions")
    TestQuestion toTestView(Question question);

    @AfterMapping
    default void addAnswerOptions(QuestionWithOptions request, @MappingTarget Question question) {
        String answerOptions = String.join("; ",
                request.optionOne(), request.optionTwo(), request.optionThree(), request.optionFour());

        question.setAnswerOptions(answerOptions);
    }
}
