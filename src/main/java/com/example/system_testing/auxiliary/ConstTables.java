package com.example.system_testing.auxiliary;

/**
 * Класс содержит константы всех имён таблиц и столбцов.
 */

public class ConstTables {

    public static final String URL_PACKAGE = "/com/example/system_testing/";

    public static final String USERS_TABLE = "tbl_users";
    public static final String USERS_ID = "id";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";
    public static final String USERS_ROLE = "role";

    public static final String TEACHERS_TABLE = "tbl_teachers";
    public static final String TEACHERS_ID = "id";
    public static final String TEACHERS_FIO = "fio";
    public static final String TEACHERS_USER_ID = "tbl_users_id";

    public static final String STUDENTS_TABLE = "tbl_students";
    public static final String STUDENTS_ID = "id";
    public static final String STUDENTS_FIO = "fio";
    public static final String STUDENTS_USER_ID = "tbl_users_id";
    public static final String STUDENTS_GROUPS_ID = "tbl_groups_id";

    public static final String ANSWERS_TABLE = "tbl_answers";
    public static final String ANSWERS_ID = "id";
    public static final String ANSWERS_NAME = "name";
    public static final String ANSWERS_IS_TRUE = "is_true";
    public static final String ANSWERS_QUESTION_ID = "tbl_questions_id";

    public static final String QUESTIONS_TABLE = "tbl_questions";
    public static final String QUESTIONS_ID = "id";
    public static final String QUESTIONS_NAME = "name";
    public static final String QUESTIONS_TESTES_ID = "tbl_testes_id";

    public static final String DISCIPLINES_TABLE = "tbs_disciplines";
    public static final String DISCIPLINES_ID = "id";
    public static final String DISCIPLINES_NAME = "name";

    public static final String TESTS_TABLE = "tbl_testes";
    public static final String TESTS_ID = "id";
    public static final String TESTS_NAME = "name";
    public static final String TESTS_DISCIPLINES_ID = "tbs_disciplines_id";

    public static final String GROUPS_TABLE = "tbl_groups";
    public static final String GROUPS_ID = "id";
    public static final String GROUPS_NUMBER = "number";

    public static final String ASSESSMENTS_TABLE = "tbl_assessments";
    public static final String ASSESSMENTS_ID = "id";
    public static final String ASSESSMENTS_ASSESSMENT = "assessment";
    public static final String ASSESSMENTS_STUDENT_ID = "tbl_students_id";
    public static final String ASSESSMENTS_TESTES_ID = "tbl_testes_id";

    public static final String SCHEDULES_TABLE = "tbl_schedules";
    public static final String SCHEDULES_ID = "id";
    public static final String SCHEDULES_DATE = "date";
    public static final String SCHEDULES_GROUPS_ID = "tbl_groups_id";
    public static final String SCHEDULES_TESTES_ID = "tbl_testes_id";

    public static final String DISCIPLINES_HAS_TEACHERS_TABLE = "tbl_teachers_has_tbs_disciplines";
    public static final String DISCIPLINES_HAS_TEACHERS_DISCIPLINES_ID = "tbs_disciplines_id";
    public static final String DISCIPLINES_HAS_TEACHERS_TEACHERS_ID = "tbl_teachers_id";

}

