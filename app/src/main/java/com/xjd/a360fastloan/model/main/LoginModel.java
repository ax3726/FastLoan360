package com.xjd.a360fastloan.model.main;

public class LoginModel {

    /**
     * token_type : Bearer
     * expires_in : 31536000
     * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImIzNzVkYzU4ZTRiZWUwZWY4MWQ3NTdhNmFkNTlkZDFkN2YzNTZkMzVhODFiZGJmZmM4YWIyYmRmNDAwMWQ0MGIxZDNjMGZkZDY4NDc0ZGIzIn0.eyJhdWQiOiIxIiwianRpIjoiYjM3NWRjNThlNGJlZTBlZjgxZDc1N2E2YWQ1OWRkMWQ3ZjM1NmQzNWE4MWJkYmZmYzhhYjJiZGY0MDAxZDQwYjFkM2MwZmRkNjg0NzRkYjMiLCJpYXQiOjE1NjMxOTE0MzMsIm5iZiI6MTU2MzE5MTQzMywiZXhwIjoxNTk0ODEzODMzLCJzdWIiOiIyIiwic2NvcGVzIjpbXX0.LMF8lYW44bFb92077iQIFObHo75FOXmq5OKJq8wpSP7Qxd2LaQ5422ttAgx_dIx7wjOaaO67YqofHG5YDz8pJBKDiI_ni98c-pG4BWA00pTY-b14qvWxOlWZ3yWsJ1KQjR1WdyX5Fp_xSakMH5V-dxB9oQzlgcz-557zqniXN7eifRBMMV37obHC5ULeMMBXcQf0gXg-UgM2_BaB1f-TStYtKcsO0cHYSBSrWvbjuVfIMXlN78vmLpmWwy4_agBvORKmbmzCTr5zzj1x661q_Sryv6hBZGTp7yiu0qIfL6WMHMHiq3vp513zbRYoZzGzVPXUfTJDyrM5QreaiA9dOSuq-ZHyh0Bl9WKPN3d0KMUP_A5ar1N4NY69weL-vmPHjnhOzKYJ10m0Kz5NaMBNqnb5fKJ8a1TUrY1dsM4Nq48B5ezmFunWVhN887SXa8eKVRs7JqQe5NoI3pxJ6-uZxWb-KYKRbHlAphTnX0RH1TnV8Z72I9nHOR9D1ykZkBveCJaUTvcJ93CeFqM4D_lgc8dGZCWMEcfmTHuwpwYvQ_qIbufpouSFw_jXh4ueBYtZsBZ2g-_1jREuDowteTHuOuANJhL3RwXy91sSJIW4kajQSJdhf6YUsIcaV97LpQiuJiYtJRpUL43Ttp2ln5rJQTr_oJpPzEL2H8Z7ms26BHc
     */

    private String token_type;
    private int expires_in;
    private String access_token;

    public String getToken_type() {
        return token_type;
    }
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
    public int getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
