package pojo;

public class User {
    private Integer ID;
    private String nickName;
    private String name;
    private String sex;
    private String password;
    private String birthTime;
    private String hand;
    private String address;
    private String phone;
    private String QQ;
    private String email;
    private String collection;

    public User() {
    }

    public User(Integer ID, String nickName, String name, String sex,
                String password, String birthTime, String hand, String address,
                String phone, String QQ, String email, String collection) {
        this.ID = ID;
        this.nickName = nickName;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.birthTime = birthTime;
        this.hand = hand;
        this.address = address;
        this.phone = phone;
        this.QQ = QQ;
        this.email = email;
        this.collection = collection;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public User(String nickName, String password, String phone, String email) {
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }


    public User(String nickName, String name, String sex, String birthTime, String address, String QQ) {
        this.nickName = nickName;
        this.name = name;
        this.sex = sex;
        this.birthTime = birthTime;
        this.address = address;
        this.QQ = QQ;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", birthTime='" + birthTime + '\'' +
                ", hand='" + hand + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", email='" + email + '\'' +
                ", collection='" + collection + '\'' +
                '}';
    }
}
