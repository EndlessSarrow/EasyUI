package cn.et.student.entity.emp;

import java.math.BigDecimal;

public class Emp {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.empno
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    private Integer empno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.ename
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    private String ename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.sal
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    private BigDecimal sal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.deptno
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    private Integer deptno;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.empno
     *
     * @return the value of emp.empno
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public Integer getEmpno() {
        return empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.empno
     *
     * @param empno the value for emp.empno
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.ename
     *
     * @return the value of emp.ename
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public String getEname() {
        return ename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.ename
     *
     * @param ename the value for emp.ename
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.sal
     *
     * @return the value of emp.sal
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public BigDecimal getSal() {
        return sal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.sal
     *
     * @param sal the value for emp.sal
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.deptno
     *
     * @return the value of emp.deptno
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.deptno
     *
     * @param deptno the value for emp.deptno
     *
     * @mbg.generated Tue Dec 26 10:07:07 CST 2017
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}