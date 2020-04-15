package com.android.androidcanvasexample;

public class Item {
    private String name;
    private Boolean value;

    public Item(String name, Boolean value) {
        this.name = name;
        this.value = value;
    }

    public Item() {
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Item)) return false;
        final Item other = (Item) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Item;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {
        return "Item(name=" + this.getName() + ", value=" + this.getValue() + ")";
    }

    public String getName() {
        return this.name;
    }

    public Boolean getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public static class ItemBuilder {
        private String name;
        private Boolean value;

        ItemBuilder() {
        }

        public Item.ItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Item.ItemBuilder value(Boolean value) {
            this.value = value;
            return this;
        }

        public Item build() {
            return new Item(name, value);
        }

        public String toString() {
            return "Item.ItemBuilder(name=" + this.name + ", value=" + this.value + ")";
        }
    }
}