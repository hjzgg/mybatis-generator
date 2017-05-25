package com.hjzgg.mybatis;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;


public class RenameMapperPlugin extends PluginAdapter {

    private String newPostfix;

    public boolean validate(List<String> warnings) {

        newPostfix = properties.getProperty("newPostfix");

        return newPostfix != null && newPostfix.length() != 0;
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.PluginAdapter#initialized(org.mybatis.generator.api.IntrospectedTable)
     */
    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        String old = introspectedTable.getMyBatis3JavaMapperType();


        old = old.replace("Mapper", newPostfix);
        introspectedTable.setMyBatis3JavaMapperType(old);

        old = introspectedTable.getMyBatis3XmlMapperFileName();
        old = old.replace("Mapper", newPostfix);
        introspectedTable.setMyBatis3XmlMapperFileName(old);

        old = introspectedTable.getSelectByPrimaryKeyStatementId();
        old = old.replace("selectByPrimaryKey", "findOne");
        introspectedTable.setSelectByPrimaryKeyStatementId(old);

        old = introspectedTable.getUpdateByPrimaryKeyStatementId();
        old = old.replace("PrimaryKey", "Id");
        introspectedTable.setUpdateByPrimaryKeyStatementId(old);

        old = introspectedTable.getDeleteByPrimaryKeyStatementId();
        old = old.replace("PrimaryKey", "Id");
        introspectedTable.setDeleteByPrimaryKeyStatementId(old);
        
        old = introspectedTable.getSelectAllStatementId();
        old = old.replace("PrimaryKey", "Id");
        introspectedTable.setSelectAllStatementId(old);
        
        old = introspectedTable.getUpdateByPrimaryKeySelectiveStatementId();
        old = old.replace("PrimaryKey", "Id");
        introspectedTable.setUpdateByPrimaryKeySelectiveStatementId(old);
        
        old = introspectedTable.getSelectByExampleStatementId();
        old = old.replace("Example", "Params");
        introspectedTable.setSelectByExampleStatementId(old);
        
        old = introspectedTable.getUpdateByExampleStatementId();
        old = old.replace("Example", "Params");
        introspectedTable.setUpdateByExampleStatementId(old);
        
        old = introspectedTable.getDeleteByExampleStatementId();
        old = old.replace("Example", "Params");
        introspectedTable.setDeleteByExampleStatementId(old);
        
        old = introspectedTable.getUpdateByExampleSelectiveStatementId();
        old = old.replace("Example", "Params");
        introspectedTable.setUpdateByExampleSelectiveStatementId(old);
        
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze,
            IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return true;
    }
    
    @Override
    public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
            IntrospectedTable introspectedTable) {
        return false;
    }
    
    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
        return false;
    }
}
