package com.gz.fz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.gz.fz.model.EpubSpine;
import com.gz.fz.utils.BaseMapper;

public interface EpubSpineMapper extends BaseMapper<EpubSpine>{

    /**
     * 批量插入
     *
     * @param spines
     * @return
     */
    @Insert("<script>" +
            "insert into epub_spine (id, cfi, cfi_base, href, s_index, s_linear, url, book_id) values " +
            "<foreach collection=\"list\" item=\"spine\" separator=\",\" >" +
                "(#{spine.id}, #{spine.cfi}, #{spine.cfi_base}, #{spine.href}, #{spine.s_index}, #{spine.s_linear}, #{spine.url}, #{spine.book_id})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSpines(List<EpubSpine> spines);

	
}
