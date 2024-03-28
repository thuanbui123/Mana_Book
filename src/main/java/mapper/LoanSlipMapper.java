/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.LoanSlipModel;
import utils.TimeConvertUtils;

/**
 *
 * @author ThuanBui
 */
public class LoanSlipMapper implements RowMapper<LoanSlipModel>{

    @Override
    public LoanSlipModel mapRow(ResultSet rs) {
        try {

            LoanSlipModel loanSlipModel = new LoanSlipModel();
            loanSlipModel.setId((int) rs.getLong("loanSlip.id"));
            loanSlipModel.setCode(rs.getString("code"));
            loanSlipModel.setIdAccount((int) rs.getLong("idAccount"));
            loanSlipModel.setIdBook((int) rs.getLong("idBook"));
            loanSlipModel.setCreated_at(rs.getTimestamp("loanSlip.created_at"));
            loanSlipModel.setUpdated_at(rs.getTimestamp("loanSlip.updated_at"));
            loanSlipModel.setTitle(rs.getString("title"));
            loanSlipModel.setUserName(rs.getString("username"));
            loanSlipModel.setNumberPhone(rs.getString("numberPhone"));

            loanSlipModel.setCreated(TimeConvertUtils.convertTimestampToDate(rs.getTimestamp("loanSlip.created_at")));
            loanSlipModel.setUpdated(TimeConvertUtils.convertTimestampToDate(rs.getTimestamp("loanSlip.updated_at")));

            return loanSlipModel;
        }catch (SQLException e) {
            return null;
        }
    }
}
