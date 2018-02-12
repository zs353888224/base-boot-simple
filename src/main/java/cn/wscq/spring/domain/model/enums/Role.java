package cn.wscq.spring.domain.model.enums;

/**
 * @author shuai
 */
public enum Role implements BaseEnum {
    ADMIN(1);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public static Role valueOf(Integer value) {
        Role[] enums = values();
        for (Role role : enums) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Illegal value");
    }

    @Override
    public int getEnumValue() {
        return this.value;
    }
}