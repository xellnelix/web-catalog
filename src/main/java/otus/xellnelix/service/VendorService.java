package otus.xellnelix.service;

import otus.xellnelix.entity.Vendor;

import java.util.List;

public interface VendorService {
    Vendor saveVendor(Vendor vendor);

    List<Vendor> findAll();
}
