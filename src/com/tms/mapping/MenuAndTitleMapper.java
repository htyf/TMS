package com.tms.mapping;

import java.util.List;
import java.util.Map;

import com.tms.model.Menu;

public interface MenuAndTitleMapper {
  List<Menu> getAllMenu();

  List<Menu> getAllTitle();
}
