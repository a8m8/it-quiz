package net.itquiz.dao.impl;

import net.itquiz.dao.TestResultDao;
import net.itquiz.entities.TestResult;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Artur Meshcheriakov
 */
@Repository("testResultImpl")
public class TestResultImpl extends AbstractEntityDao<TestResult> implements TestResultDao {

    @Override
    protected Class<TestResult> getEntityClass() {
        return TestResult.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TestResult> listRelatedTo(int idAccount, int offset, int count) {
        return getSession().createCriteria(getEntityClass()).add(Restrictions.eq("account.idAccount", idAccount))
                .addOrder(Order.asc("created")).setFirstResult(offset).setMaxResults(count).list();
    }

    @Override
    public long countAllRelatedTo(int idAccount) {
        return (long) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("account.idAccount",
                idAccount)).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public TestResult findByTestTitleRelatedTo(int idAccount, String testTitle) {
        return (TestResult) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("account.idAccount",
                idAccount)).add(Restrictions.eq("testTitle", testTitle).ignoreCase()).uniqueResult();
    }
}
