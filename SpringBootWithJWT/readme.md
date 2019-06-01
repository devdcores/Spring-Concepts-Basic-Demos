
Admin
userName: admin.admin
password: jwtpass

Normal User
userName: john.doe
password: jwtpass


To get the accessToken

curl TestJwtClientId:Abcd1234Secret@localhost:9090/oauth/token -d grant_type=password -d username=admin.admin -d password=jwtpass


There are 2 rest endpoints 

/books -> needs Admin or User role to access.
/users -> needs only Admin role to access.

After getting accessToken call rest endpoint passing accessToken in header.

curl http://localhost:9090/api/books -H "Authorization: Bearer <access_token>"