package cn.wscq.spring.domain.model.mybatis;

public class TDemo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_demo.test_id
     *
     * @mbg.generated
     */
    private Long testId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_demo.test_name
     *
     * @mbg.generated
     */
    private String testName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_demo.test_id
     *
     * @return the value of t_demo.test_id
     *
     * @mbg.generated
     */
    public Long getTestId() {
        return testId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_demo.test_id
     *
     * @param testId the value for t_demo.test_id
     *
     * @mbg.generated
     */
    public void setTestId(Long testId) {
        this.testId = testId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_demo.test_name
     *
     * @return the value of t_demo.test_name
     *
     * @mbg.generated
     */
    public String getTestName() {
        return testName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_demo.test_name
     *
     * @param testName the value for t_demo.test_name
     *
     * @mbg.generated
     */
    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }
}