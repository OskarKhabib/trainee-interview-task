package khabibullin.interviewtask.entity;

import jakarta.persistence.Entity;

@Entity
public class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final Double price;
    private final Boolean inStock;

    private Product(Long id, String name, String description, Double price, Boolean inStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    public static ProductBuilder builder(){
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private Long id;
        private String name;
        private String description;
        private Double price;
        private Boolean inStock;

        public ProductBuilder() {
        }

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder inStock(Boolean inStock) {
            this.inStock = inStock;
            return this;
        }

        public Product build() {
            //defaults
            if (inStock == null) {
                inStock = false;
            }
            if (price == null) {
                price = 0D;
            }

            return new Product(id, name, description, price, inStock);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!getId().equals(product.getId())) return false;
        if (!getName().equals(product.getName())) return false;
        if (!getDescription().equals(product.getDescription())) return false;
        if (!getPrice().equals(product.getPrice())) return false;
        return getInStock().equals(product.getInStock());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getInStock().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                '}';
    }
}
