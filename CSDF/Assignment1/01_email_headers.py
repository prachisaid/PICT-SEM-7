import email

f = open('/home/harsh/PICT-SEM-7/CSDF/Assignment1/email.eml')
msg = email.message_from_file(f)
f.close()

parser = email.parser.HeaderParser()
headers = parser.parsestr(msg.as_string())

print('Headers Found: ')
for i in headers.items():
    print(i)
x = headers.items()[6][-1]
print(f'SPF and DKIM is {x}')