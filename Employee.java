package lesson5;

class Employee {
    
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    
    Employee(String fullName, String position, String email, String phone, int salary, int age) {
        if (fullName == null || position == null || email == null || phone == null || salary < 0 || age <= 0)
            System.out.println("Something going wrong initializing class Employee.. Please, check your input data");
        else {
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public int getSalary() {
        return salary;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setFullName(String fullName) {
        if (fullName != null)
            this.fullName = fullName;
    }
    
    public void setPosition(String position) {
        if (position != null)
            this.position = position;
    }
    
    public void setEmail(String email) {
        if (email != null)
            this.email = email;
    }
    
    public void setPhone(String phone) {
        if (phone != null)
            this.phone = phone;
    }
    
    public void setSalary(int salary) {
        if (salary >= 0)
            this.salary = salary;
    }
    
    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }
    
  
    @Override
    public String toString() {
        return "Full name: " + fullName + "" + "\n"+ "Position: " + position + "\n" + "E-mail: " + email + "\n"+ "Phone: " + phone + "\n" + "Salary: " + salary + "\n" + "Age: " + age + "\n";
    }
}
