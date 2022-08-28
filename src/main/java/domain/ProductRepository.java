package domain;

public class ProductRepository {

    private Product[] product = new Product[0];

    public void save(Product item) {
        int length = product.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(product, 0, tmp, 0, product.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        product = tmp;
    }

    public Product[] findAll() {
        return product;
    }

    public Product[] findById(int id) {
        for (Product product : product) {
            if (product.getId() == id) {
                return new Product[]{product};
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = product.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : product) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
            product = tmp;
        }
    }




