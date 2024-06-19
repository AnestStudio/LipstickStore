package org.anest.mystore.service;

import org.anest.mystore.entity.Product;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public interface ReportService {

    void outputExcel(List<Product> products, ByteArrayOutputStream stream) throws IOException;
}
