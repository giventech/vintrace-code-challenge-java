#Pull docker images to build React App
FROM node:13.12.0-alpine as development
WORKDIR /app 



ENV PATH /app/node_modules/.bin:$PATH


COPY ./package.json ./
COPY ./package-lock.json ./
RUN npm install 
RUN npm install react-scripts@latest -g 

COPY . .

# start app
CMD ["npm", "start"]

#Package the application to serve the app